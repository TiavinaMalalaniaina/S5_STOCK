import { Sidebar, Menu, MenuItem, useProSidebar } from "react-pro-sidebar";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
import ReceiptOutlinedIcon from "@mui/icons-material/ReceiptOutlined";
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import { Link } from "react-router-dom";

export default function MySidebar() {
    
    const { collapseSidebar } = useProSidebar();
    const cssLink = {
        textDecoration: "none", 
        color: "inherit"
    }
    
    return (
        <Sidebar style={{ height: "100vh" }}>
            <Menu style={{ height: "100vh", backgroundColor: "white" }}>
                <MenuItem icon={<MenuOutlinedIcon />} onClick={() => { collapseSidebar(); }} style={{ textAlign: "center" }}>
                    <h2>STOCKING</h2>
                </MenuItem>
                <Link to="/" style={ cssLink }>
                    <MenuItem icon={<HomeOutlinedIcon />}>
                    Stock
                    </MenuItem>
                </Link>
                <Link to="/entry" style={ cssLink }>
                    <MenuItem icon={<PeopleOutlinedIcon />}>
                        Entrée
                    </MenuItem>
                </Link>
                <Link to="/output" style={ cssLink }>
                    <MenuItem icon={<ReceiptOutlinedIcon />}>
                        Sortie
                    </MenuItem>
                </Link>
            </Menu>
        </Sidebar>
    )
}