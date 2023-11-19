export default function TableRow({item}) {
    return (
        <>
            <tr>
                <td>{item.articleName}</td>
                <td>{item.unity}</td>
                <td>{item.amountFinal.toLocaleString()}</td>
                <td>{item.quantityInit.toLocaleString()}</td>
                <td>{item.quantityFinal.toLocaleString()}</td>
                <td>{item.quantityEntry.toLocaleString()}</td>
                <td>{item.quantityOutput.toLocaleString()}</td>
                <td>{item.cump.toLocaleString()}</td>
                <td>{item.storeName}</td>
            </tr>
        </>
    );
}