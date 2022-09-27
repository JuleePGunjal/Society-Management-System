
import {useState,useEffect} from 'react'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router'

const Addcomplaint = ()=> {
    const [complaint,setComplaint] = useState('')

    const navigate=useNavigate()

  const addcomplaint = () => {
      if(complaint.length===0){
        toast.warning('Please enter complaint')
      }else{
        const body = {
          complaint,
          status : 'PENDING',
          ownerId : sessionStorage.getItem('id')
     }
     // url to call api
        const url="http://localhost:8080/complaint/addcomplaint"

       // http method: post
      // body: contains the data to be sent to the API
      axios.post(url, body).then((response) => {
        // get the data from the response
        const result = response.data
        console.log(result)
        if (result['status'] === 'success') {
          toast.success('Successfully added complaint')

          // navigate to the signin page
          navigate('/home')
        } else {
          toast.error(result['error'])
        }
      })
        
    }
      
  }
    
    return(
        <div>
    

    <Link to='/home'>Back</Link>
    <div className="row">
        <div className="col"></div>
        <div className="col">
        <h1 className='title'>ADD Complaint</h1>
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Complaint
              </label>
              <input
            onChange={(e) => {
                setComplaint(e.target.value)
            }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
             
              <button  onClick={addcomplaint} className="btn btn-primary">
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


export default Addcomplaint
