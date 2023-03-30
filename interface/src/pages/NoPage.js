import {Button, Container} from "react-bootstrap";

export default function NoPage() {
    return (
        <>
            <Container style={{paddingTop: '200px'}}>
                <div className="d-flex align-items-center justify-content-center">
                    <div className="text-center">
                        <h1 className="display-1 fw-bold">404</h1>
                        <p className="fs-3"><span className="text-danger">Opps!</span> Page not found.</p>
                        <p className="lead">
                            The page you’re looking for doesn’t exist.
                        </p>
                        <Button href="/" className="updateButton">Go Home</Button>
                    </div>
                </div>
            </Container>
        </>
    )
}