import './Contact.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';

import { withReactRouter } from "../../util/util";
import { isAdminUser, isUser } from "../../auth/authUtil";

import { Container } from "react-bootstrap";

export async function loader({ params }) {
}

class Contact extends React.Component {

    render() {
        return (

            <Container fluid>

            </Container>
        )
    }
}

export default withReactRouter(Contact);