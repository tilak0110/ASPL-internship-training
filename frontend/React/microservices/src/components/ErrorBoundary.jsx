import { Component } from 'react';

class ErrorBoundary extends Component {
  state = { hasError: false, error: null };

  static getDerivedStateFromError(error) {
    return { hasError: true, error };
  }

  componentDidCatch(error, errorInfo) {
    console.error('Error caught by boundary:', error, errorInfo);
  }

  handleReset = () => {
    this.setState({ hasError: false, error: null });
  };

  render() {
    if (this.state.hasError) {
      return (
        <div style={styles.overlay}>
          <div style={styles.card} className="error-boundary">
            <svg
              viewBox="0 0 24 24"
              width="48"
              height="48"
              fill="none"
              style={{ marginBottom: 16 }}
              aria-hidden="true"
            >
              <circle cx="12" cy="12" r="10" fill="#fddede" />
              <path
                d="M12 8v4M12 16h.01"
                stroke="#de3a3a"
                strokeWidth="2"
                strokeLinecap="round"
              />
            </svg>
            <h2 style={styles.heading}>Something went wrong</h2>
            <p style={styles.message}>
              {this.state.error?.message || "An unexpected error occurred."}
            </p>
            <button style={styles.button} onClick={this.handleReset}>
              Try Again
            </button>
          </div>
        </div>
      );
    }
    return this.props.children;
  }
}


const styles = {
  overlay: {
    minHeight: "100vh",
    minWidth: "100vw",
    background: "rgba(250,250,252,0.95)",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    fontFamily: "'Inter', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif",
    zIndex: 9999,
    padding: 16,
  },
  card: {
    background: "#fff",
    padding: "2rem 2.5rem 2rem 2.5rem",
    borderRadius: 12,
    boxShadow: "0 6px 24px rgba(220,80,80,0.12)",
    maxWidth: 380,
    width: "100%",
    textAlign: "center",
    border: "1px solid #fae3e3",
  },
  heading: {
    color: "#de3a3a",
    marginBottom: 8,
    fontWeight: 700,
  },
  message: {
    margin: "8px 0 16px 0",
    color: "#222",
    fontSize: 16,
  },
  button: {
    background: "linear-gradient(90deg,#d85151 0%,#de7c3a 100%)",
    color: "white",
    border: "none",
    borderRadius: 6,
    padding: "0.6rem 1.6rem",
    cursor: "pointer",
    fontWeight: 600,
    letterSpacing: "0.03em",
    fontSize: 16,
    transition: "box-shadow 0.16s",
    boxShadow: "0 2px 6px rgba(220,80,80,0.12)",
  },
};

export default ErrorBoundary;
