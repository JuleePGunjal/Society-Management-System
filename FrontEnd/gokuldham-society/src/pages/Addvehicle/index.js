
import {useState,useEffect} from 'react'
import { Link} from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'

const Addvehicle = ()=> {
    let navigate = useNavigate();
    const [vehicleNo,setVehicleNo] = useState('')
    const [flat,setFlat]=useState([]);
    const [flatId,setFlatId]=useState(-1);
    const [wing,setWing]=useState('');
    const [wingList,setWingList]=useState([]);
     //used to navigate from one component to other
  // const navigate=useNavigate()

  useEffect(()=>{
    const url=`http://localhost:8080/society/getFlat/${sessionStorage.getItem("id")}`

    axios.get(url).then((response) => {
        const result = response.data
        const array = result['data'].map((f)=>f.wing);
        const arr = array.filter((item,i,ar)=>ar.indexOf(item)==i);
        setWingList([...arr])
        setFlat(result['data']);
    })
},[]);

  const addvehicle = () => {
      if(vehicleNo.length===0){
        toast.warning('Please enter Vehicle No')
      }else if (flatId ===-1){
        toast.warning('please select flat')
    }
        else{
        const body = {
            flatId : flat.filter((f)=>f.wing===wing).filter((ft)=>ft.flatNo==flatId)[0].id,
         vehicleNo
     }
     console.log(body)
     // url to call api
        const url="http://localhost:8080/vehicle/addvehicle"

       // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] === 'success') {
          toast.success('Successfully Add Vehicle')
          navigate("/vehicle");
          // navigate to the signin page
          //navigate('/signin')
        } else {
          toast.error(result['error'])
        }
      })
        
    }
      
  }
    
    return(
        <div>
             <h1>ADD Vehicle Number</h1>
             <Link to='/home'>Back</Link>
    
    <div className="row">
    
        <div className="col"></div>

        <div className="col">
        
       
        <div className="form">
          <div className="mb-3">
              <label htmlFor="" className="label-control">
                Wing
              </label>&emsp;&emsp;
              <select onChange={(e) => {
                    setWing(e.target.value)

                }}>
                     <option>...</option>
                 {
                  wingList.map((f)=>{
                      return(
                        <option>{f}</option>
                      )
                  })
              }
             </select>
             </div>
          <div className="mb-3">
              <label htmlFor="" className="label-control">
                Flat
              </label>&emsp;&emsp;
              <select onChange={(e) => {
                  setFlatId(e.target.value)
                }}>
                     <option>...</option>
                 {
                  flat.filter((f)=>f.wing==wing).map((f)=>{
                      return(
                        <option value={f.flatId}>{f.flatNo}</option>
                      )
                  })
              }
             </select>
             
            </div>
                <div className="mb-3">
                <label htmlFor="" className="label-control">
                Vehicle No:
              </label>
              <input
            onChange={(e) => {
                setVehicleNo(e.target.value)
            }}
                type="text"
                className="form-control"
              />
                </div>
        
            <div className="mb-3">
             
              <button  onClick={addvehicle} className="btn btn-primary">
                Add Vehicle
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
    )
}


export default Addvehicle
