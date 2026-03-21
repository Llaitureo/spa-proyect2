import { useEffect, useState } from "react";

function App() {
  const [planes, setPlanes] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  
  useEffect(() => {
    fetch("http://localhost:8080/api/planes")
    .then(resp=>{
      if (!resp.ok) throw new Error("Error al conseguir los planes");
      return resp.json();
    })
    .then(data => {
      setPlanes(data);
      setLoading(false);
    })
    . catch(ex=>{
      setError(ex.message);
      setLoading(false);
    })
  }, [])

  return (
    <div className={`container-principal ${error ? 'status-error' : ''}`}>

      <div className="container-mensajes">
        <h1>Planes</h1>
        {loading && <p><strong>Cargando planes...</strong></p>}
        {error && (
          <div className="error-box">
            <p className="error"><strong>Error: {error}</strong></p>
            <button onClick={() => window.location.reload()}>Reintentar</button>
          </div>
        )}
      </div>
      
      {!error && (
        <ul class="container-planes">
        {planes.map(plan => (
          <li class="plan" key={plan.id}>
            <h2>{plan.nombre}</h2>
            <p>{plan.descripcion}</p>
            <strong>Precio: </strong>{plan.precio} CLP
            <button className="btn-comprar">Comprar</button>
          </li>
        ))}
      </ul>)}
      {!loading && !error && (
        <div className="container-recargar">
          <button onClick={() => window.location.reload()}>Recargar</button>
        </div>
      )}
    </div>
  );
}

export default App;
