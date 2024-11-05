import styleMain from "./Main.module.css";
import { CarFilters } from "../carFilter/CarFilters.tsx";

export function Main() {
  return (
    <div className={styleMain.div}>
      <CarFilters></CarFilters>
    </div>
  );
}
