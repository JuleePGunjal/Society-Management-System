
import {Link} from 'react-router-dom'
import { useState ,useEffect } from 'react';
import { toast } from 'react-toastify';
import axios from 'axios';
import { useNavigate } from 'react-router';

const AddVisitor = () =>{
    const [name, setName] = useState('')
    const [contactNo, setContactNo] = useState('') 
    const [flat,setFlat]=useState([]);
    const [flatId,setFlatId]=useState(-1);
    const [wing,setWing]=useState('');
    const [wingList,setWingList]=useState([]);
	  
    const navigate=useNavigate()


    useEffect(()=>{
        const url="http://localhost:8080/society/flatlist"
    
        axios.get(url).then((response) => {
            const result = response.data
            const array = result['data'].map((f)=>f.wing);
            const arr = array.filter((item,i,ar)=>ar.indexOf(item)==i);
            setWingList([...arr])
            setFlat(result['data']);
        })
    },[]);


    const addvisitor = () =>{
        if(name.length==0){
            toast.warning('Please enter Name')
        }else if(contactNo.length==0){
            toast.warning('Please enter Contact No.')
        }else{
            const body = {
                name,
                contactNo,
            
	            flatId:flat.filter((f)=>f.wing===wing).filter((ft)=>ft.flatNo==flatId)[0].id,
	           
	
            }
            const url = 'http://localhost:8080/visitor/addvisitor'
           axios.post(url, body).then(response =>{
               const result = response.data

               if(result['status']== 'success'){
                   toast.success('Successfully added!')
                   navigate("/visitor")
               }else{
                   toast.error(result['Error'])
               }
           })
        }
    } 
    return(
    <div>
        <h1>Add Visitor</h1>

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
                Name
              </label>
              <input
            onChange={(e) => {
                setName(e.target.value)
            }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Contact Number
              </label>
              <input
                 onChange={(e) => {
                    setContactNo(e.target.value)
                }}
                type="text"
                className="form-control"
              />
            </div>      

            <div className="mb-3">
             
              <button  onClick={addvisitor} className="btn btn-primary">
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




export default AddVisitor


