import CardTitle from "../components/card/CardTitle";
import { useEffect, useState } from "react";
import API_CONFIG from "../config/apiconfig";
import Form from "../components/forms/Form";

export default function Validate() {
    const [data, setData] = useState([])
    const elements = [
        {
            "name":"id",
            "label":"Demande", 
            "type":"select",
            "values":data,
        },
        {
            "name":"validationDate",
            "label":"Date",
            "type":"date",
            "value":new Date().toISOString().split('T')[0]
        }
    ]

    useEffect(() => {
        fetch(API_CONFIG.BASE_URL + API_CONFIG.REQUESTS)
            .then(response => response.json())
            .then(response => {
                setData(response.data)
                console.log(response.data)
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
        e.preventDefault()
        const formData = new FormData(e.target)
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: toJson(formData)
        }
        fetch(API_CONFIG.BASE_URL + API_CONFIG.VALIDATE_REQUEST ,requestOptions)
            .then(response => response.json())
            .then(response => {
                if (response.error != null && response.error !== '' ) alert(response.error)
                else                                                  alert("Votre demande a été validé avec succés")
            })
            .catch((error) => console.log(error));
    }

    const handleChange=(e)=>{
        
    }

    return (
        <>
            <div className="container">
                <div className="row">
                    <CardTitle title={"Demande de sortie"}/>
                    <div className="card mt-4">
                        <div className="card-body">
                        <form onSubmit={handleSubmit}>
                            {elements.map((element, index) => <Form filter={element} key={index} func={handleChange}/> )}
                            <button type="submit" className='btn btn-primary'>Valider</button>
                        </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}