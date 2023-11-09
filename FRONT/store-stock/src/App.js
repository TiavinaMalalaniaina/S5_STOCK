import { BrowserRouter as Router, Route } from 'react-router-dom';
import StockAvailability from './pages/StockAvailability'

function App() {
  return (
    <div className="App">
      
      <Router>
          <Route path="/add" exact component={StockAvailability} />
      </Router>
    </div>
  );
}

export default App;
