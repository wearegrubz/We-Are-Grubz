import {Link} from "react-router-dom";

function Navbar() {
    return (
        <>
            <nav className="navbar bg-light">
                <div className="container" style={{margin:"0"}} >
                    <a className="navbar-brand" href="#">
                        <Link to="/"><img src="/assets/images/grubz_red_transparent.png" alt="grubz_logo" height="50" /></Link>
                    </a>
                </div>
            </nav>
        </>
    );
}

export default Navbar;