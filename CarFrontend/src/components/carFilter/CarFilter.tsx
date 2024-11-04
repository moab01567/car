import styleCarFilter from "./CarFilter.module.css";
import Select from "react-select";

export function CarFilter() {
  const myData = [
    { label: "Books", value: 1 },
    { label: "Movies, Music & Games", value: 2 },
    { label: "Electronics & Computers", value: 3 },
    { label: "Home, Garden & Tools", value: 4 },
    { label: "Health & Beauty", value: 5 },
    { label: "Toys, Kids & Baby", value: 6 },
    { label: "Clothing & Jewelry", value: 7 },
    { label: "Sports & Outdoors", value: 8 },
    { label: "Automotive & Industrial", value: 9 },
  ];

  return (
    <div className={styleCarFilter.div}>
      <h2>Toyota Land Cruiser</h2>

      <div className={styleCarFilter.selectDiv}>
        <h3>Seats</h3>
        <Select
          placeholder="Seats"
          closeMenuOnSelect={false}
          options={myData}
          isMulti
        />
      </div>
    </div>
  );
}
