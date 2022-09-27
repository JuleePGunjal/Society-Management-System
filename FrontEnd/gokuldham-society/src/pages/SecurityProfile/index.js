import { Link } from "react-router-dom"

const SecurityProfile=()=>{
return(
    <>
    <h1>Security Profile</h1>
    <Link to='/home'>Back</Link>
    <div className="row">
        
       
        <div className="col"></div>
        <div className="col">
        
        {/* <Link to='/updateowner'>Update Profile</Link>
        &emsp;&emsp;
        <Link to='/updatepassword'>Change Password</Link> */}
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                 Name
              </label>
              <h3>{sessionStorage.getItem('name')}</h3>
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Password
              </label>
              <h3>{sessionStorage.getItem('password')}</h3>
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Month Salary
              </label>
              <h3>{sessionStorage.getItem('monthSalary')}</h3>
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Address
              </label>
              <h3>{sessionStorage.getItem('address')}</h3>
            </div>


            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Contact Number
              </label>
              <h3>{sessionStorage.getItem('contactNo')}</h3>
            </div>
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email
              </label>
              <h3>{sessionStorage.getItem('email')}</h3>
            </div>
            

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Role
              </label>
              <h3>{sessionStorage.getItem('role')}</h3>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
      </>
)
}
export default SecurityProfile