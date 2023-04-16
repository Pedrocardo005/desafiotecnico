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
        console.log('O repositório', usuario.repositorios);
      })
      .catch(erro => {
        alert("Erro ao realizar a requisição: " + erro.response.data.msg);
      });
  };
  
  return (
    <div className="App">
      <form>
        <div className='form-group d-inline-block'>
          <input value={nome} onChange={onChangeNome} type="text"/>
        </div>
        <div className='form-group d-inline-block'>
          <input onClick={findUser} type="submit" className='btn btn-info' />
        </div>
      </form>
      {
        usuario ? (
          <div>
            <div className='text-left auto col-xl-4 col-md-6'>
              <p>Login: {usuario.login}</p>
              <p>Criado em: {usuario.created_at}</p>
              <p>Repositórios</p>
            </div>
            {
              usuario.repositorios.length ? (
              <table className='table text-left'>
                <thead>
                  <tr>
                    <th>Nome</th>
                    <th>Linguagem</th>
                  </tr>
                </thead>
                <tbody>
                {
                  usuario.repositorios.map((repositorio) => (
                    <tr>
                      <td>{repositorio.name}</td>
                      <td>{repositorio.language}</td>
                    </tr>
                  ))
                }
                </tbody>
              </table>
              ) : (
                <div class="alert alert-danger">
                  Nenhum repositório encontrado!
                </div>
              )
            }
          </div>
        ) : (
          <div></div>
        )
      }
    </div>
  );
}

export default App;
