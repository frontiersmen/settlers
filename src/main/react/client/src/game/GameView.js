import React, { Component } from 'react';
import GameConnection from './gameConnection.js';

export default class GameView extends Component {
  constructor(props) {
    super(props);
    this.state = {
      gameConnection: null,
      game: null
    };
    this.startGame = this.startGame.bind(this);
  }

  componentWillMount() {
    var gameConnection = new GameConnection(this.props.match.params.id, this.props.playerId, this.props.authToken);
    gameConnection.on("GameUpdateEvent", (event) => {
      this.setState({ game: event.game });
      console.log("Updated game state", this.state.game);
    });
    this.setState({ gameConnection: gameConnection });
  }

  componentWillUnmount() {
    this.state.gameConnection.disconnect();
  }

  startGame() {
    this.state.gameConnection.startGame();
  }

  render() {
    if (this.state.game) {
      return (
        <div>
          <p>{this.state.game.id}</p>
          <p>{this.state.game.owner}</p>
          <p>{this.state.game.name}</p>
          {this.state.game.pregame ? <button onClick={this.startGame}>Start</button> : null}
        </div>
      );
    } else {
      return <div>Loading...</div>
    }
  }
}
