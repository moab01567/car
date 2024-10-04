import { FilterDataApi } from "./FilterDataApi";

const filterStructure = [
    { urlParameter: "carType", filterType: "carType", filterName: "Car Type", filterOptions: [] },
    { urlParameter: "carFuel", filterType: "carFuel", filterName: "Car Fuel", filterOptions: [] },
    { urlParameter: "carStatus", filterType: "carStatus", filterName: "Car Status", filterOptions: [] },
    { urlParameter: "handleStatus", filterType: "handleStatus", filterName: "Car Handle Status", filterOptions: [] },
    { urlParameter: "carSeats", filterType: "carSeats", filterName: "Car Seats", filterOptions: [] },
    { urlParameter: "transmission", filterType: "carTransmission", filterName: "Transmission", filterOptions: [] }
];

export async function FilterDataTransformer() {
    for (const filter of filterStructure) {
        filter.filterOptions = await FilterDataApi(filter.urlParameter);
    }
    return filterStructure;
}
