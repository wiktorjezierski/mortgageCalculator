// import { Component } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { ChartHandleService } from './ChartHandle/chart-handle.service';
import { RestService } from './rest/rest.service';
import { ChartData } from './chart-data';
import { Data } from './data';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private chartHandle: ChartHandleService,
              private restService: RestService) { }

  kwota: number;
  okres: number;
  marza: number;
  wibor: number;
  prowizja: number;
  nadplata: number;
  opoznienieNadplaty: number;
  czestotliwoscNadplaty: number;
  rodzajNadplaty: string;

  public model: Data[];

  title = 'Kallkulator kredytu hipotecznego';
  click(event) {
    this.restService.calculate().subscribe(data => {
      this.model = data;
      this.chartHandle.showChartRatyRowne(data[0].chartData);
      this.chartHandle.showChartRatyMalejace(data[1].chartData);
    });
  }

  ngOnInit() {
    const data = [
      new ChartData(450, 'Kwota'),
      new ChartData(120, 'Odsetki'),
      new ChartData(300, 'Nadplata')
    ];

    this.chartHandle.showChartRatyRowne(data);
  }
}


