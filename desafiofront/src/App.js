import { useState } from 'react';
import './App.css';

function App() {
  const [nome, setNome] = useState("");

  const onChangeNome = (value) => {
    setNome(value.target.value);
  };

  const findUser = (value) => {
    value.preventDefault();
    
    const options = {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json;charset=UTF-8",
      }
    };

    fetch("http://localhost:8080?nome=" + nome, options)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      });
  };
  
  return (
    <div className="App">
      <form>
        <input value={nome} onChange={onChangeNome} type="text"/>
        <input onClick={findUser} type="submit"/>
      </form>
    </div>
  );
}

export default App;
