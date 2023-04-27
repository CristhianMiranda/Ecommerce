import "./Header.css"


function Header()
{
    return <header className="headerPrincipal">
        <div className="container" id="header">
            <h1 className="headerPrincipal-titulo">
                <img className="logo" src="/img/logo.png" alt="Logo de CinePrime"/>
            </h1>
            <nav className="headerPrincipal-nav">
                <button className="ingresar">
                    <a className="headerPrincipal-nav-link" id="lista" href="index.html">Ver Productos</a>
                </button>
                <button className="ingresar">
                    <a className="headerPrincipal-nav-link" href="#">Mi Carrito</a>
                </button>

                <button className="ingresar">
                    <a className="headerPrincipal-nav-link login" href="#"><img className="user" src="/img/cliente.png"/></a>
                </button>

            </nav>
        </div>
    </header>

}

export default Header