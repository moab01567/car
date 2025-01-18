export interface SelectFilterDTOAndMapper {
    selectFilterCode: string;
    filterName: string;
    filterOptionDTOS: [
        {
            optionId: number;
            option: string;
        },
    ];
}