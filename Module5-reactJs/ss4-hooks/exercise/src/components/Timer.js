import { useState } from "react";
import { useEffect } from "react";
function Timer() {
    const [timer, setTimer] = useState(3);

    useEffect(() => {
        let timerId = setInterval(() => {
            setTimer( prevState=> {
                if (prevState === 0) { 
                    clearInterval(timerId); 
                    alert('Time out!')
                    return 
                }
                return prevState - 1
            })
        }, 1000)

        // setTimeout(() => {
        //     alert('Time out!')
        // }, 11000)

        return () => {
            console.log('Clean up interval!');
            clearInterval(timerId);
        }
    }, []);

    return (
        <>
            <h1>COUNT DOWN {timer}</h1>
        </>
    );
}

export default Timer;