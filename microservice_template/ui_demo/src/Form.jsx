import React, {Component} from 'react';
const Worker =  require('worker-loader!./worker.js');

export default class Form extends Component {

    constructor(props) {
        super(props);
        if (window.Worker) {
            this.textResult = React.createRef();
            this.myWorker = new Worker("worker.js");
            this.myWorker.onmessage = function(e) {
                this.textResult.current.textContent = e.data;
                console.log('Message received from worker');
            }
        }else{
            console.warn("worker not supported.")
        }
        this.state = {first:null, second: null};
    }

    updateState = (val, prop) => {
        this.setState({[prop]:val})
    };

    btnClick = ()=>{
        console.log('Message posted to worker');
        this.myWorker.postMessage("dsdsddsd");
    };

    render() {
        return (
            <div>
                <input id="number1" onBlur={(val)=>this.updateState(val, 'first')}/>
                <input id="number2" onBlur={(val)=>this.updateState(val, 'second')}/>
                <button onClick={this.btnClick}>calcFromWorker</button>
                <span>sum is :</span>
                <p ref = {this.textResult} />
            </div>
        );
    }
}
