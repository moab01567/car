import {FilterAPI} from "../service/CarFilterService";
import React, { useEffect, useState } from "react";
import style from "./CarFilterDetails.module.css";
import { Box, Chip, FormControl, InputLabel, MenuItem } from "@mui/material";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import {LocalStorageCarFilter} from "../LocalStorageCarFilter";
import { SelectFilterCode } from "../Enum";

import {SelectFilterDTOAndMapper} from "../DTO/SelectFilterDTOAndMapper";

interface Props {
  carTypeId: number;
  selectFilterCode: SelectFilterCode;
}

export function CarFilterSelector({ carTypeId, selectFilterCode }: Props) {
  const [selectedOptionsIds, setSelectedOptionsIds] = useState<number[]>([]);
  const [selectFilter, setSelectFilter] = useState<SelectFilterDTOAndMapper | null>(
    null,
  );

  async function getCarFilterAndOption() {
    const selectFilterDTO: SelectFilterDTOAndMapper = await FilterAPI.APIGetCarFilterAndOptions(
      carTypeId,
      selectFilterCode,
    );
    setSelectFilter(selectFilterDTO);
    const selectedOptionsIdsFromLocalStorage: number[] = LocalStorageCarFilter.getSelectedData(
      carTypeId,
      selectFilterCode,
    );
    setSelectedOptionsIds(selectedOptionsIdsFromLocalStorage);
  }

  useEffect(() => {
    getCarFilterAndOption();
  }, []);

  function handleChange(event: SelectChangeEvent<number[]>) {
    if (!Array.isArray(event.target.value)) return;
    const selected: number[] = event.target.value;
    setSelectedOptionsIds(selected);
    LocalStorageCarFilter.updateSelectedData(carTypeId, selectFilterCode, selected);
  }

  function renderValue(): string[] {
    if (!selectFilter) return [];
    return selectedOptionsIds.map((optionId) => {
      const filterOption = selectFilter.filterOptionDTOS.find(
        (filterOption) => filterOption.optionId === optionId,
      );
      return filterOption?.option || "Missing";
    });
  }

  return (
    <div className={style.DivCarFilterSelector}>
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">
          {selectFilter?.filterName || "Loading"}
        </InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          multiple
          value={selectedOptionsIds}
          onChange={(event) => handleChange(event)}
          label={selectFilter?.filterName || "Loading"}
          renderValue={(selected) => (
            <Box sx={{ display: "flex", flexWrap: "wrap", gap: 0.5 }}>
              {renderValue().map((value) => (
                <Chip key={value} label={value} />
              ))}
            </Box>
          )}
        >
          {selectFilter?.filterOptionDTOS.map((filterAndOptions) => (
            <MenuItem
              key={filterAndOptions.optionId}
              value={filterAndOptions.optionId}
            >
              {filterAndOptions.option}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
    </div>
  );
}
