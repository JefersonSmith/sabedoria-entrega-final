import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'bootstrap/dist/css/bootstrap.min.css';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-xl">
      <div className="container-fluid ">
        <a className="navbar-brand" href="/">
          <h1 className="m-0 texto-logo">
            <img className="logo-nav" src="../assets/logo.png" alt="logotipo" />
            Sabedoria+
          </h1>
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item me-4">
              <a
                className="nav-link botao-nav2"
                aria-current="page"
                href="/"
              >
                Início
              </a>
            </li>
            <li className="nav-item me-4">
              <a className="nav-link botao-nav2 " href="sobreNos.html">
                Sobre Nós
              </a>
            </li>
            <li className="nav-item me-4">
              <a className="nav-link botao-nav" href="mentores.html">
                Mentores
              </a>
            </li>
            <li className="nav-item me-4">
              <a className="nav-link botao-nav" href="login">
                Login
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link botao-nav" href="register">
                Cadastro
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
