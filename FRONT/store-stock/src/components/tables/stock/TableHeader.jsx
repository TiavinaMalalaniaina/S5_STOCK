export default function TableHeader() {
    const headers = [
        "Article", "Unité", "Montant", "Quantité initial", "Reste", "Entrée", "Sortie", "Magasin"
    ];
    
    return (
        <>
            <thead>
                <tr>
                    {headers.map((header, index) => <th key={index}>{header}</th>)}
                </tr>
            </thead>
        </>
    )

}