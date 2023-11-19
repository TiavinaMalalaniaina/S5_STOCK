import Form from '../../forms/Form';
import { useState, useEffect } from 'react';
import API_CONFIG from './../../../config/apiconfig';


export default function FormEntry() {
    const [articles, setArticles] = useState([]);
    const [stores, setStores] = useState([]);
    const elements = [
        {
            "name":"articleId",
            "label":"Article", 
            "type":"select",
            "values":articles,
        },
        {
            "name":"dateEntry",
            "label":"Date",
            "type":"date",
            "value": new Date().toISOString().split('T')[0]
        },
        {
            "name":"storeId",
            "label":"Magasin",
            "type":"select",
            "values":stores,
        },
        {
            "name":"quantity",
            "label":"Quantité",
            "type":"number",
        },
        {
            "name":"unitPrice",
            "label":"Prix unitaire",
            "type":"number",
        }
    ]
    const handleChange = (e) => {
    };

    useEffect(() => {
        fetch(API_CONFIG.BASE_URL + API_CONFIG.STORES_API)
          .then(response => response.json())
          .then(response => {
            setStores(response.data)
          })
          .catch((error) => console.log(error));
    }, []);

    useEffect(() => {
        fetch(API_CONFIG.BASE_URL + API_CONFIG.ARTICLES_FINAL_API)
            .then(response => response.json())
            .then(response => {
                setArticles(response.data)
            })
            .catch((error) => console.log(error));
    }, []);

    const toJson = (formData) => {
        const objet = {};
        formData.forEach((valeur, clé) => {
          objet[clé] = valeur;
        });
        const jsonData = JSON.stringify(objet);
        return jsonData;
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: toJson(new FormData(e.target))
        }
        fetch(API_CONFIG.BASE_URL + API_CONFIG.ADD_ENTRY ,requestOptions)
            .then(response => response.json())
            .then(response => {
                alert(response.data);
            })
            .catch((error) => console.log(error));
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                {elements.map((element, index) => <Form filter={element} key={index} func={handleChange}/> )}
                <button type="submit" className='btn btn-primary'>Valider</button>
            </form>
        </>
    )
}