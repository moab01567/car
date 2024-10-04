import { createContext, useState } from 'react';

// Opprett CarContext
export const CarContext = createContext();

// Provider for å dele state mellom komponentene
export function CarProvider({ children }) {
    const [carDetails, setCarDetails] = useState(null);
    const [ownersInfo, setOwnersInfo] = useState(null);

    return (
        <CarContext.Provider value={{ carDetails, setCarDetails, ownersInfo, setOwnersInfo }}>
            {children}
        </CarContext.Provider>
    );
}
