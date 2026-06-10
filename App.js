import React, { useState } from 'react';
import './App.css';

function App() {
  const [page, setPage] = useState('home');
  const [token, setToken] = useState('');
  const [message, setMessage] = useState('');

  // Register
  const [regData, setRegData] = useState({ fullName: '', email: '', password: '', role: 'SEEKER' });
  
  // Login
  const [loginData, setLoginData] = useState({ email: '', password: '' });
  
  // Jobs
  const [jobs, setJobs] = useState([]);

  const register = async () => {
    const res = await fetch('http://localhost:8080/api/users/register', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(regData)
    });
    if(res.ok) { setMessage('Registered! Ab login karo!'); setPage('login'); }
    else setMessage('Error!');
  };

  const login = async () => {
    const res = await fetch('http://localhost:8080/api/users/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(loginData)
    });
    const data = await res.text();
    setToken(data);
    setMessage('Login successful!');
    setPage('jobs');
    
    // Token seedha pass karo fetchJobs mein
    const jobsRes = await fetch('http://localhost:8080/api/jobs/all', {
        headers: {
            'Authorization': `Bearer ${data}`
        }
    });
    const jobsData = await jobsRes.json();
    console.log("Jobs:", jobsData);
    setJobs(jobsData);
  };

  const fetchJobs = async () => {
    const res = await fetch('http://localhost:8080/api/jobs/all', {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });
    const data = await res.json();
    setJobs(data);
  };

  const applyJob = async (jobId) => {
    const res = await fetch('http://localhost:8080/api/applications/apply', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ job: { id: jobId }, appliedBy: { id: 1 } })
    });
    if(res.ok) setMessage('Applied successfully!');
  };

  return (
    <div className="app">
      <nav className="navbar">
        <h1>🏥 MedJobs India</h1>
        <div>
          <button onClick={() => setPage('home')}>Home</button>
          <button onClick={() => setPage('register')}>Register</button>
          <button onClick={() => setPage('login')}>Login</button>
        </div>
      </nav>

      {message && <div className="message">{message}</div>}

      {page === 'home' && (
        <div className="hero">
          <h2>Medical Jobs & Internships</h2>
          <p>India's  Dedicated Job Portal for Medical Professionals & Students</p>
          <button onClick={() => setPage('register')}>Get Started</button>
        </div>
      )}

      {page === 'register' && (
        <div className="form-box">
          <h2>Register</h2>
          <input placeholder="Full Name" onChange={e => setRegData({...regData, fullName: e.target.value})} />
          <input placeholder="Email" onChange={e => setRegData({...regData, email: e.target.value})} />
          <input placeholder="Password" type="password" onChange={e => setRegData({...regData, password: e.target.value})} />
          <select onChange={e => setRegData({...regData, role: e.target.value})}>
            <option value="SEEKER">Job Seeker (Doctor/Student)</option>
            <option value="EMPLOYER">Employer (Hospital/Institute)</option>
          </select>
          <button onClick={register}>Register</button>
        </div>
      )}

      {page === 'login' && (
        <div className="form-box">
          <h2>Login</h2>
          <input placeholder="Email" onChange={e => setLoginData({...loginData, email: e.target.value})} />
          <input placeholder="Password" type="password" onChange={e => setLoginData({...loginData, password: e.target.value})} />
          <button onClick={login}>Login</button>
        </div>
      )}

      {page === 'jobs' && (
        <div className="jobs-page">
          <h2>Available Jobs</h2>
          <div className="jobs-grid">
            {jobs.map(job => (
              <div className="job-card" key={job.id}>
                <h3>{job.title}</h3>
                <p>📍 {job.location}</p>
                <p>🏥 {job.specialization}</p>
                <p>💼 {job.jobType}</p>
                <p>{job.description}</p>
                <button onClick={() => applyJob(job.id)}>Apply Now</button>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

export default App;