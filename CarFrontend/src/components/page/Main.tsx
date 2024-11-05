import styleMain from "./Main.module.css";
import { CarFilters } from "../carFilter/CarFilters.tsx";

export function Main() {
  return (
    <div className={styleMain.div}>
      <h1>Car Finder</h1>
      <CarFilters></CarFilters>
    </div>
  );
}
