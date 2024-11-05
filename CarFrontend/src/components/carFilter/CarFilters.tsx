import { CarFilter } from "./CarFilter.tsx";
import styleCarFilters from "./CarFilters.module.css";

export function CarFilters() {
  return (
    <div className={styleCarFilters.div}>
      <CarFilter></CarFilter>
      <CarFilter></CarFilter>
      <CarFilter></CarFilter>
    </div>
  );
}
