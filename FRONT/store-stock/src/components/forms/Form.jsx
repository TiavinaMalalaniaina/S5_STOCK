import Select from "./Select";
import Input from "./Input";

export default function Form({filter, func}) {
    let component = null;
    if (filter.type === "select") component = <Select filter={filter} func={func}/>
    else component = <Input filter={filter} func={func}/>
    return (
        <>
            <div className="mb-3">
                <label className="form-label">{filter.label}</label>
                {component}
            </div>
        </>
    );
}