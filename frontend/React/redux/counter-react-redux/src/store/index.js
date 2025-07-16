import {createStore} from 'redux';

const INITIAL_VALUE={
    counter: 0
}

const counterReducer = ( store= INITIAL_VALUE , action) => {
    console.log(`action  recived ${action.type}`);
    switch (action.type) {
        case "INCREMENT":
            return {counter: store.counter+1};
        case "DECREMENT":
            return {counter: store.counter-1};  
        default:
            return store;
    }
}

const counterStore =createStore(counterReducer);

export default counterStore;