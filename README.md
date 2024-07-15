import React, { useState } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const history = useHistory();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      // Simplified login logic for demonstration
      if (username === 'manager' && password === 'password') {
        localStorage.setItem('auth', 'true');
        history.push('/employees');
      } else {
        alert('Invalid credentials');
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;



import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    const fetchEmployees = async () => {
      const result = await axios.get('http://localhost:8080/api/employees');
      setEmployees(result.data);
    };

    fetchEmployees();
  }, []);

  return (
    <div>
      <h2>Employee List</h2>
      <ul>
        {employees.map((employee) => (
          <li key={employee.id}>{employee.name} - {employee.position} - {employee.department}</li>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeList;



import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CalendarView = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      const result = await axios.get('http://localhost:8080/api/calendar-events');
      setEvents(result.data);
    };

    fetchEvents();
  }, []);

  return (
    <div>
      <h2>Calendar View</h2>
      <ul>
        {events.map((event) => (
          <li key={event.id}>{event.title} - {event.date} - {event.type}</li>
        ))}
      </ul>
    </div>
  );
};

export default CalendarView;



import React, { useEffect, useState } from 'react';
import axios from 'axios';

const OrganizationalEvents = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      const result = await axios.get('http://localhost:8080/api/organizational-events');
      setEvents(result.data);
    };

    fetchEvents();
  }, []);

  return (
    <div>
      <h2>Organizational Events</h2>
      <ul>
        {events.map((event) => (
          <li key={event.id}>{event.title} - {event.date}</li>
        ))}
      </ul>
    </div>
  );
};

export default OrganizationalEvents;



export const isAuthenticated = () => {
  return localStorage.getItem('auth') === 'true';
};

export const logout = () => {
  localStorage.removeItem('auth');
};


import axios from 'axios';

const API_URL = 'http://localhost:8080/api/employees';

export const fetchEmployees = () => {
  return axios.get(API_URL);
};

export const addEmployee = (employee) => {
  return axios.post(API_URL, employee);
};



import axios from 'axios';

const API_URL = 'http://localhost:8080/api/calendar-events';

export const fetchCalendarEvents = () => {
  return axios.get(API_URL);
};

export const addCalendarEvent = (event) => {
  return axios.post(API_URL, event);
};


import axios from 'axios';

const API_URL = 'http://localhost:8080/api/organizational-events';

export const fetchOrganizationalEvents = () => {
  return axios.get(API_URL);
};

export const addOrganizationalEvent = (event) => {
  return axios.post(API_URL, event);
};



import React from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import Login from './components/Login';
import EmployeeList from './components/EmployeeList';
import CalendarView from './components/CalendarView';
import OrganizationalEvents from './components/OrganizationalEvents';
import { isAuthenticated } from './services/authService';

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={(props) =>
      isAuthenticated() ? <Component {...props} /> : <Redirect to="/" />
    }
  />
);

const App = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={Login} />
        <PrivateRoute path="/employees" component={EmployeeList} />
        <PrivateRoute path="/calendar" component={CalendarView} />
        <PrivateRoute path="/events" component={OrganizationalEvents} />
      </Switch>
    </Router>
  );
};

export default App;
