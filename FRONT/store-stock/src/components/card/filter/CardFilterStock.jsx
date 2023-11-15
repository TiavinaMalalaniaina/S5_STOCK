import Form from "./../../forms/Form";
import React, { useState, useEffect } from "react";
import API_CONFIG from './../../../config/apiconfig';

function CardFilterStock({updateFilters, handleInputChange}) {
    const [articles, setArticles] = useState([]);
    const [stores, setStores] = useState([]);

    useEffect(() => {
        fetch(API_CONFIG.BASE_URL + API_CONFIG.STORES_API)
          .then(res => res.json())
          .then(res => {
            setStores(res.data)
          })
          .catch((error) => console.log(error));
    }, []);

    useEffect(() => {
        fetch(API_CONFIG.BASE_URL + API_CONFIG.ARTICLES_API)
          .then(res => res.json())
          .then(res => {
            setArticles(res.data)
          })
          .catch((error) => console.log(error));
    }, []);
    
    const filters = [
        {
            "name":"start",
            "label":"Début",
            "type":"date",
            "value":'2000-01-01',
        },
        {
            "name":"end",
            "label":"Final",
            "type":"date",
            "value":new Date().toISOString().split('T')[0],
        },
        {
            "name":"articleId",
            "label":"Articles",
            "type":"select",
            "values":articles,
        },
        {
            "name":"storeId",
            "label":"Magasin",
            "type":"select",
            "values":stores,
        }
    ];

    const handleSubmit = (e) => {
        e.preventDefault()
        const formData = new FormData(e.target)
        updateFilters(formData)
    }

    return (
        <div className="card mt-4">
            <div className="card-body">
                <form onSubmit={handleSubmit}>
                    {filters.map((filter, index) => 
                        <Form filter={filter} key={index} func={handleInputChange}/> 
                    )}
                    <button type="submit" className="btn btn-primary">Valider</button>
                </form>
            </div>
        </div>
    );
}
  
export default CardFilterStock;