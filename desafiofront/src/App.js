import { useState } from 'react';
import './App.css';
import UsuarioDataService from "./services/UsuarioDataService";

function App() {
  const [nome, setNome] = useState("");
  const [usuario, setUsuario] = useState();

  const onChangeNome = (value) => {
    setNome(value.target.value);
  };

  const findUser = (value) => {
    value.preventDefault();
    
    UsuarioDataService.get(nome)
      .then(response => {
        setUsuario(response.data);
      })
      .catch(erro => {
        alert("Erro ao realizar a requisição: " + erro.response.data.msg);
      });
  };
  
  return (
    <div className="App">
      <form>
        <input value={nome} onChange={onChangeNome} type="text"/>
        <input onClick={findUser} type="submit"/>
      </form>
      {
        usuario ? (
          <div>
            <p>Login: {usuario.login}</p>
            <p>Criado em: {usuario.created_at}</p>
            <p>Repositórios</p>
            <table>
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Línguagem</th>
                </tr>
              </thead>
              <tbody>
              {
                usuario.repositorios &&
                usuario.repositorios.map((repositorio) => (
                  <tr>
                    <td>{repositorio.name}</td>
                    <td>{repositorio.language}</td>
                  </tr>
                ))
              }
              </tbody>
            </table>
          </div>
        ) : (
          <div></div>
        )
      }
    </div>
  );
}

export default App;
