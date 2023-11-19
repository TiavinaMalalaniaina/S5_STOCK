export default function Input({filter, func}) {
    return (
        <>
            <input type={filter.type} className="form-control" name={filter.name} placeholder={filter.label} defaultValue={filter.value} onChange={func}/>
        </>
    )
}