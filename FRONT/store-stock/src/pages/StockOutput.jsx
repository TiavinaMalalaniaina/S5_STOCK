import CardOutput from "../components/card/entry/CardOutput";
import CardTitle from "../components/card/CardTitle";

export default function StockOutput() {
    return (
        <>
            <div className="container">
                <div className="row">
                    <CardTitle title={"Sortie de stock"}/>
                    <CardOutput/>
                </div>
            </div>
        </>
    );
}