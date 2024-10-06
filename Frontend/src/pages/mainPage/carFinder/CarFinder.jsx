import {FilterSelector} from "./FilterSelector";
import * as React from "react";
import {useEffect, useState} from "react";
import {TextField} from '@mui/material';
import {FilterDataTransformer} from "../../../Service/requestFilterData/FilterDataTransformer";
import {DatePicker, LocalizationProvider} from "@mui/x-date-pickers";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import MainPageStyle from "../MainPage.module.css";
import Button from "@mui/material/Button";
import {LoadingIndicator} from "../../../components/LoadingIndicator.jsx";


export function CarFinder({setSelectedFilterOptions, setSearchFilterValue}){
    const [filters,setFilters] = useState([])
    const [loading,setLoading] = useState(false)

    useEffect(()=> {
        async function getFilterData(){
            setLoading(true)
            setFilters([])
            setFilters(await FilterDataTransformer())
            setLoading(false)
        }
        getFilterData()
        setSelectedFilterOptions(oldSate=>({...oldSate,["carFrom"]:""}))
        setSelectedFilterOptions(oldSate=>({...oldSate,["carTo"]:""}))
        setSelectedFilterOptions(oldSate=>({...oldSate,["euFrom"]:""}))
        setSelectedFilterOptions(oldSate=>({...oldSate,["euTo"]:""}))
        setSelectedFilterOptions(oldSate=>({...oldSate,["reg"]:""}))
        setSelectedFilterOptions(oldSate=>({...oldSate,["tlf"]:""}))

    },[])

    return <div>
        {loading ? <LoadingIndicator></LoadingIndicator> : ""}

        {filters.map(filter =>(
            <FilterSelector  key={filter.filterType}
                             filter={filter}
                             setSelected={setSelectedFilterOptions}>
            </FilterSelector>))
        }
        <LocalizationProvider dateAdapter={AdapterDayjs} adapterLocale="de" >
            <DatePicker className={MainPageStyle.DatePicker}
                        onChange={(newValue)=>{
                            setSelectedFilterOptions((oldState)=>
                                ({...oldState, ["carFrom"] : newValue===null ? "" : `${newValue['$y']}-${newValue['$M']+1}-${newValue['$D']}`}))}}
                        label={"Car From"}/>
        </LocalizationProvider>

        <LocalizationProvider  dateAdapter={AdapterDayjs} adapterLocale="de">
            <DatePicker className={MainPageStyle.DatePicker}
                        onChange={(newValue)=>
                            setSelectedFilterOptions((oldState)=>
                                ({...oldState, ["carTo"] : newValue===null ? "" : `${newValue['$y']}-${newValue['$M']+1}-${newValue['$D']}`}) )}
                        label={"car To"}  />
        </LocalizationProvider>

        <LocalizationProvider  dateAdapter={AdapterDayjs} adapterLocale="de">
            <DatePicker className={MainPageStyle.DatePicker}
                        onChange={(newValue)=>
                            setSelectedFilterOptions((oldState)=>
                                ({...oldState, ["euFrom"] : newValue===null ? "" : `${newValue['$y']}-${newValue['$M']+1}-${newValue['$D']}`}))}
                        label={"EU From"} />
        </LocalizationProvider>

        <LocalizationProvider  dateAdapter={AdapterDayjs} adapterLocale="de">
            <DatePicker className={MainPageStyle.DatePicker}
                        onChange={(newValue)=> setSelectedFilterOptions((oldState)=>
                            ({...oldState, ["euTo"] : (newValue===null ? "" : `${newValue['$y']}-${newValue['$M']+1}-${newValue['$D']}`)}  ))}
                        label={"EU To"}
            />
        </LocalizationProvider>

        <TextField className={MainPageStyle.DatePicker} onChange={(e)=> {setSelectedFilterOptions((oldState)=> ({...oldState, ["reg"] : e.target.value}))}} id="REG" label="REG" variant="outlined" />
        <TextField className={MainPageStyle.DatePicker} onChange={(e)=> {setSelectedFilterOptions((oldState)=> ({...oldState, ["tlf"] : e.target.value}))}} id="TLF" label="TLF" variant="outlined" />
        <Button className={MainPageStyle.FilterButton} type="submit"  variant="contained">Filter</Button>
    </div>
}