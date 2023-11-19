export default function Select({filter, func}) {

    return (
        <>
            <select className="form-select" aria-label="Default select example" name={filter.name} onChange={func}>
                {filter.values.map((value, index) => 
                    <option value={value.id} key={index}>{value.name}</option>
                )}
            </select>
        </>
    )
}