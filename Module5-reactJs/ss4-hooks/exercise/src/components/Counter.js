import { useState, useEffect } from "react";
import useClock from "./useClock";
import useIncrease from "./useIncrease";
function Counter() {
    const [counter1, setCounter1] = useIncrease(0);
    const [time, ampm] = useClock();

    return (
        <>
            <div id="Clock-style">
                {time}
                <span> {ampm}</span>
            </div>

            <h1>Count: {counter1}</h1>
            <button onClick={setCounter1}>Add 1</button>
        </>
    )
}

export default Counter;