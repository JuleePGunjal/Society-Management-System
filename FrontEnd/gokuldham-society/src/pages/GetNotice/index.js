
import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import { toast } from 'react-toastify'
import { Link } from 'react-router-dom'

const GetNotice = (props) => {
  const [notice, setNotice] = useState([]);

 
  useEffect(() => {
    const url = "http://localhost:8080/noticeBoard/noticeBoardlist"
    axios.get(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setNotice(result['data'])
      } else {
        toast.error(result['error'])
      }
    })
  }, [])



    

  return (
      <>
      <h1>Notice</h1>
      <Link to='/home'>Back</Link>
     
    <table class="table" id="customers">
    <thead class="thead-light">
      <tr>
        <th scope="col">#</th>
       
       
        <th scope="col">Notice</th>
        <th scope="col">Date</th>
      
        
      </tr>
    </thead>
    <tbody>
        {
            
            notice.map((item,i)=>{
                return(
                    <tr>
                        <th scope="row">{i+1}</th>
                        
                        
                        <td>{item.noticemsg}</td>
                        <td>{item.noticeDate}</td>
                        <td><button 
                             const onClick={()=>{
                                {const url = `http://localhost:8080/noticeBoard/deletebyid/${item.id}`
                                axios.delete(url)
                                //     { headers: {
                                //     'Content-Type': 'text/plain;charset=utf-8',
                                // }})
                                .then((response) => {
                                  const result = response.data
                                  if (result['status'] == 'success') {
                                    toast.success("user successfully deleted")
                                    window.location.reload()
                                  } 
                                })  
                              }}}
                        type="button" class="btn btn-danger" >Delete</button></td> 
                    </tr>
                )
            })
        }
    </tbody>
  </table>
  </>
  )
}

export default GetNotice
