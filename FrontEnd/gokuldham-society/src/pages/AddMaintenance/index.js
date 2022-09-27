
import {useState,useEffect} from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'

const Addmaintenance = ()=> {
    const [flatMaintenance,setFlatMaintenace] = useState('')
    const [month, setMonth] = useState('')
    const [waterBill, setWaterBill] = useState('')
    const [parkingBill, setParkingBill] = useState('')
    const [others, setOther] = useState('')
    const [flat,setFlat]=useState([]);
    const [flatId,setFlatId]=useState(-1);
    const [wing,setWing]=useState('');
    const [wingList,setWingList]=useState([]);
    //used to navigate from one component to other
    const navigate=useNavigate()
    useEffect(()=>{
        const url="http://localhost:8080/society/flatlist"

        axios.get(url).then((response) => {
            const result = response.data
            const array = result['data'].filter(i=>i.ownerFirstName!=null).map((f)=>f.wing);
            const arr = array.filter((item,i,ar)=>ar.indexOf(item)==i);
            setWingList([...arr])
            setFlat(result['data']);
        })
  },[]);

 

  const addmaintenance = () => {
      if(flatMaintenance.length===0){
        toast.warning('Please enter flatMaintenance')
      }else if (flatId ===-1){
        toast.warning('please select flat')
    }else if (month.lenght===0){
          toast.warning('please enter the month')
      }else if (waterBill.length===0){
        toast.warning('please enter the waterBill')
    }else if (parkingBill.length===0){
        toast.warning('please enter the parkingBill')
    }else if (others.length===0){
            toast.warning('please enter others')
    }else{
        const body = {
            flatId : flat.filter((f)=>f.wing===wing).filter((ft)=>ft.flatNo==flatId)[0].id,
            flatMaintenance,
            month,
            waterBill,
            parkingBill,
            others
     }
     console.log(body)
     // url to call api
        const url="http://localhost:8080/maintenance/addmaintenace"

       // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] === 'success') {
          toast.success('Successfully Add Maintenance')

          // navigate to the signin page
          navigate('/viewmaintenance')
        } else {
          toast.error(result['error'])
        }
      })
        
    }
      
  }
    
    return(
        <div>
     <h1 className='title'>ADD Maintenance</h1>
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
                  flat.filter(i=>i.ownerFirstName!=null).filter((f)=>f.wing==wing).map((f)=>{
                      return(
                        <option value={f.flatId}>{f.flatNo}</option>
                      )
                  })
              }
             </select>
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Flat Maintenance
              </label>
              <input
            onChange={(e) => {
                setFlatMaintenace(e.target.value)
            }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Water Bill
              </label>
              <input
                 onChange={(e) => {
                    setWaterBill(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Combined Electricity Bill
              </label>
              <input
                 onChange={(e) => {
                    setMonth(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Parking Bill
              </label>
              <input
                  onChange={(e) => {
                    setParkingBill(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Others
              </label>
              <input
                onChange={(e) => {
                  setOther(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>

         

            <div className="mb-3">
             
              <button  onClick={addmaintenance} className="btn btn-primary">
                Add 
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
    )
}


export default Addmaintenance