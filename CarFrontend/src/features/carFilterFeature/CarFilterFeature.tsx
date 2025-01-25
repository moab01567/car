import React, { useEffect, useState } from "react";
import { CarFilter } from "./carFilter/CarFilter";
import {FilterAPI} from "./service/CarFilterService";
import CarFilterStyle from "./CarFilterFeature.module.css";
import Button from "@mui/material/Button";
import "./LocalStorageCarFilter";
import { LocalStorageCarFilter} from "./LocalStorageCarFilter";

import {CarDTO} from "./DTO/CarDTO";
import {SelectedFilterOptionDTOMapper} from "./DTO/SelectedFilterOptionDTOAndMapper";
import {FilterSortBy} from "./FilterSortBy/FilterSortBy";

function handleFilterClick() {

    FilterAPI.APIPostCarFilterAndOptions(SelectedFilterOptionDTOMapper(LocalStorageCarFilter.getFilterDate()))
}

export function CarFilterFeature() {
  const [carFilters, setCars] = useState<CarDTO[] | null>(null);

  useEffect(() => {
    getCarsToFilter();
  }, []);

  async function getCarsToFilter() {
    const cars: CarDTO[] = await FilterAPI.APIGetAvailableCars();
    setCars(cars);
    cars.forEach((car) => LocalStorageCarFilter.addCarToFilterData(car.carId));
  }

  if (carFilters === null) {
    return (
      <div className={CarFilterStyle.Div}>
        <h2>Car Filter</h2>
        loading...
      </div>
    );
  }

  return (
    <div className={CarFilterStyle.Div}>
      <h2>Car Filter</h2>
      <div className={CarFilterStyle.CarFilterDiv}>
        {carFilters.map((carFilter) => (
          <CarFilter key={carFilter.carId} carFilter={carFilter}></CarFilter>
        ))}
      </div>
       <FilterSortBy></FilterSortBy>
      <Button onClick={handleFilterClick} variant="contained">Filter</Button>
    </div>
  );
}
