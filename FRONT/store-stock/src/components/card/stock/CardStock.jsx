import Table from '../../tables/stock/Table';

function Card({data}) {
    return (
      <div className="card mt-4">
        <div className="card-body">
          <Table data={data}/>
        </div>
      </div>
    );
  }
  
export default Card;