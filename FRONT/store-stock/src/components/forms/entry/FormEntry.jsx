import Form from '../../forms/Form';
import { useState, useEffect } from 'react';
import API_CONFIG from './../../../config/apiconfig';


export default function FormEntry() {
    const [postData, setPostData] = useState({
        articleId: '',
        dateEntry: new Date().toISOString().split('T')[0],
        storeId: '',
        quantity: '',
        unitPrice: ''
    });
    const [articles, setArticles] = useState([]);
    const [stores, setStores] = useState([]);
    const elements = [
        {
            "name":"articleId",
            "label":"Article", 
            "type":"select",
            "values":articles,
            "value":postData.articleId,
        },
        {
            "name":"dateEntry",
            "label":"Date",
            "type":"date",
            "value":postData.dateEntry
        },
        {
            "name":"storeId",
            "label":"Magasin",
            "type":"select",
            "values":stores,
            "value":postData.storeId
        },
        {
            "name":"quantity",
            "label":"Quantité",
            "type":"number",
            "value":postData.quantity
        },
        {
            "name":"unitPrice",
            "label":"Prix unitaire",
            "type":"number",
            "value":postData.unitPrice
        }
    ]
    const handleChange = (e) => {
        const { name, value } = e.target;
        setPostData(prevData => ({
            ...prevData,
            [name]: value,
        }));
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
        fetch(API_CONFIG.BASE_URL + API_CONFIG.ARTICLES_API)
            .then(response => response.json())
            .then(response => {
                setArticles(response.data)
            })
            .catch((error) => console.log(error));
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(postData)
        }
        fetch(API_CONFIG.BASE_URL + API_CONFIG.ADD_ENTRY ,requestOptions)
            .then(response => response.json())
            .then(response => {
                alert(response);
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