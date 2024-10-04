import {Box, Chip, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import * as React from "react";
import {useEffect, useRef, useState} from "react";


export function FilterSelector({setSelected, filter}){
    const [selectedName, setSelectedName] = useState([]);

    useEffect(()=>{
        setSelected(oldState => ({...oldState, [filter.filterType]: []}))
    },[])

    return <FormControl sx={{ m: 1, width: 300 }}>
        <InputLabel id="carLabelId">{filter.filterName}</InputLabel>
        <Select
            multiple
            labelId="carLabelId"
            id="demo-simple-select"
            value={selectedName}
            label={filter.filterName}
            onChange={event => {
                console.log(event.target.value)
                setSelectedName(event.target.value);
                setSelected(oldState => ({...oldState, [filter.filterType]: event.target.value}))
            }
        }

            renderValue={(item) => (
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                {item.map((value) => (
                    <Chip  key={value} label={filter.filterOptions.find((option)=> option.optionId === value).optionName} />
                ))}
            </Box>
        )}>
            {filter.filterOptions.map((option) => (
                <MenuItem  key={option.optionId} value={option.optionId}>
                    {option.optionName}
                </MenuItem>
            ))}

        </Select>
    </FormControl>

}