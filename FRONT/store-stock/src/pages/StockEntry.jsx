import CardEntry from "../components/card/entry/CardEntry";
import CardTitle from "../components/card/CardTitle";

export default function StockEntry() {
    return (
        <>
            <div className="container">
                <div className="row">
                    <CardTitle title={"Entrée de stock"}/>
                    <CardEntry/>
                </div>
            </div>
        </>
    );
}