import TableHeader from './TableHeader';
import TableBody from './TableBody';

export default function Table({data}) {//TODO header est une variable a passer

    return (
        <>
            <table className='table table-striped'>
                <TableHeader/>
                <TableBody items={data}/>
            </table>
        </>
    );
}