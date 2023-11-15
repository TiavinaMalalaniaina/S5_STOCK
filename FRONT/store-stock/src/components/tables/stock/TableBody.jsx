import TableRow from './TableRow';

export default function TableBody({items}) {
    return (
        <>
            <tbody>
                {items.map((item, index) => <TableRow item={item} key={index}/>)}
            </tbody>
        </>
    )
}