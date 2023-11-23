import { Routes, Route } from 'react-router-dom';
import MySidebar from './components/sidebar/MySidebar';
import { ProSidebarProvider } from 'react-pro-sidebar';
import StockAvailability from './pages/StockAvailability';
import StockEntry from './pages/StockEntry';
import StockOutput from './pages/StockOutput';
import './styles/bootstrap/css/bootstrap.min.css';
import './styles/css/App.css';
import RequestOutput from './pages/RequestOutput';
import Validate from './pages/Validate';

function App() {
  return (
    <div className="App" style={({ height: "100vh" }, { display: "flex" })}>
      <ProSidebarProvider>
        <MySidebar/>
        <div className="container" style={{ padding: "50px" }}>
          <div className="row">
            <Routes>
              <Route path='/' element={<StockAvailability/>}/>
              <Route path='/entry' element={<StockEntry/>}/>
              <Route path='/output' element={<StockOutput/>}/>
              <Route path='/request' element={<RequestOutput />}/>
              <Route path='/validate' element={<Validate />}/>
            </Routes>
          </div>
        </div>
      </ProSidebarProvider>
    </div>
  );
}

export default App;
