function CardTitle({start, end}) {
  const data = require('../../../data/stock.json');
    return (
      <div className="card mt-4">
        <div className="card-body">
          <center>
            <h1>Etat de stock</h1>
            <h3>Du {start} au {end}</h3>
          </center>
        </div>
      </div>
    );
  }
  
export default CardTitle;