import React, { useState } from "react";
import CardFilterStock from "../components/card/filter/CardFilterStock";
import CardStock from "../components/card/stock/CardStock";
import CardTitle from "../components/card/stock/CardTitle";
import API_CONFIG from "../config/apiconfig";

export default function StockAvailability() {
  const [data, setData] = useState([]);
  
  const handleInputChange = (e) => {
  };

  const toJson = (formData) => {
    const objet = {};
    formData.forEach((valeur, clé) => {
      objet[clé] = valeur;
    });
    const jsonData = JSON.stringify(objet);
    return jsonData;
  }

  const updateFilters = (formData) => {
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: toJson(formData)
    };
  
    fetch(API_CONFIG.BASE_URL + API_CONFIG.STOCK_API, requestOptions)
    .then(res => res.json())
    .then(res => {
      console.log(res)
      setData(res.data)
    })
    .catch((error) => console.log(error));
  }

  return (
    <div className="container">
      <div className="row">
        <CardTitle start={data.start} end={data.end}/>
        <div className="col-8">
          <CardStock data={data} />
        </div>
        <div className="col-4">
          <CardFilterStock updateFilters={updateFilters} handleInputChange={handleInputChange}/>
        </div>
      </div>
    </div>
  );
}
