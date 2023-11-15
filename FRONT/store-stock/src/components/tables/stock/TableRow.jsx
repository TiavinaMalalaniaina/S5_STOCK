export default function TableRow({item}) {
    return (
        <>
            <tr>
                <td>{item.articleName}</td>
                <td></td>
                <td>{item.amountFinal}</td>
                <td>{item.quantityInit}</td>
                <td>{item.quantityFinal}</td>
                <td>{item.quantityEntry}</td>
                <td>{item.quantityOutput}</td>
                <td>{item.storeName}</td>
            </tr>
        </>
    );
}